import React, { useEffect, useState } from 'react';
import { fetchTasks, addTask, completeTask, deleteTask } from './api';
import './App.css';

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTaskTitle, setNewTaskTitle] = useState('');

  const loadTasks = async () => {
    const res = await fetchTasks();
    setTasks(res.data);
  };

  const handleAdd = async () => {
    if (!newTaskTitle.trim()) return;
    await addTask(newTaskTitle);
    setNewTaskTitle('');
    loadTasks();
  };

  const handleComplete = async (id) => {
    await completeTask(id);
    loadTasks();
  };

  const handleDelete = async (id) => {
    await deleteTask(id);
    loadTasks();
  };

  useEffect(() => {
    loadTasks();
  }, []);

  return (
    <div className="app">
      <h1>Java Task Manager</h1>

      <div className="input-group">
        <input
          type="text"
          placeholder="Enter new task..."
          value={newTaskTitle}
          onChange={(e) => setNewTaskTitle(e.target.value)}
        />
        <button onClick={handleAdd}>Add Task</button>
      </div>

      <ul>
        {tasks.map((task) => (
          <li key={task.id} className={task.completed ? 'done' : ''}>
            <span onClick={() => handleComplete(task.id)}>
              {task.title}
            </span>
            <button onClick={() => handleDelete(task.id)}>✕</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
