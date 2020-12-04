import React, { Component } from 'react';
import './App.css';
import AddToDoItem from './components/AddToDoItem';
import ToDoItem from './components/ToDoItem';

class App extends Component {
  state = {
    taskList: []
  }

  componentDidMount() {    
    this.fetchTasks();
  }

  fetchTasks = () => {
    fetch('http://localhost:8080/api/todolist').then((res) =>
      res.json()
    ).then(data => {
      this.setState({
        taskList: data
      })      
    });
  }

  updateServer = (thisTask) => {
    
    fetch(`http://localhost:8080/api/todolist/${thisTask.id}`, {
      method: 'PUT',
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(thisTask),
    }).then(res => res.json()
    ).then(data => {
      this.fetchTasks();
    })
  }

  render() {
    
    return (
      <div className="App">
        <h1>
          To-Do App
        </h1>
        <table>
          <thead>
              <tr>
                  <th>Task Name</th>
                  <th>Completed?</th>
              </tr>
          </thead>
          <tbody>
            {this.state.taskList.map((task, i) =>
              <ToDoItem task={task} key={i} updateServer={this.updateServer}/>
            )}
          </tbody>
        </table>
        <AddToDoItem taskList={this.state.taskList} fetchTasks={this.fetchTasks}/>
      </div>
    );
  }
}

export default App;
