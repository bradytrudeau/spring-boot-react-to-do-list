import React, { Component } from 'react';

class ToDoItem extends Component {

  handleInputChange = () => {
    this.props.updateServer({...this.props.task, isCompleted: !this.props.task.isCompleted});
  }

  render() {
    return (
            <tr>
              <td>
                {this.props.task.task}
              </td>
              <td>
                <input type="checkbox" checked={this.props.task.isCompleted} onChange={this.handleInputChange}>
                </input>
              </td>
            </tr>
    );
  }
}

export default ToDoItem;