import React, { Component } from 'react';

class AddToDoItem extends Component {

  state = {
    newTask: {
      id: null,
      task: '',
      isCompleted: false
    }
  }

  handleChangeFor = (property, event) => {
    this.setState({
        newTask: {
            ...this.state.newTask,
            id: this.props.taskList.length + 1,
            [property]: event.target.value,
        }
    });
}

  addTask = () => {    
    fetch(`http://localhost:8080/api/todolist/`, {
      method: 'POST',
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(this.state.newTask),
    }).then(res => res.json()
    ).then(data => {
      this.props.fetchTasks();
      this.setState({
        newTask: {
          id: null,
          task: '',
          isCompleted: false
        }
      })
    })
  }

  render() {
    
    return (
      <div>
        <h2>Add New Task</h2>
        <input
          type="text" 
          value={this.state.newTask.task} 
          onChange={(event) => this.handleChangeFor('task', event)}
        />
        <button onClick={() => this.addTask(this.state.newTask)}>Add Task</button>
      </div>
    )
  }
}

export default AddToDoItem;