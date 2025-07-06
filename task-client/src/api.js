import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080', // Java backend base URL
});

// Fetch all tasks
export const fetchTasks = () => API.get('/tasks');

// Add a new task
export const addTask = (title) => API.post('/tasks', { title });

// Complete a task
export const completeTask = (id) => API.put(`/tasks/${id}/complete`);

// Delete a task
export const deleteTask = (id) => API.delete(`/tasks/${id}`);
