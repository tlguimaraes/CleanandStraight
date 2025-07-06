import React from 'react';
import './../App.css'; // Optional: for styling

function TaskList({ tasks, onComplete, onDelete }) {
  if (tasks.length === 0) {
    return <p>No tasks yet. Add one!</p>;
  }

  return (
    <ul className="task-list">
      {tasks.map((task) => (
        <li key={task.id} className={task.completed ? 'done' : ''}>
          <span onClick={() => onComplete(task.id)}>
            {task.title}
          </span>
          <button onClick={() => onDelete(task.id)}>✕</button>
        </li>
      ))}
    </ul>
  );
}

export default TaskList;
