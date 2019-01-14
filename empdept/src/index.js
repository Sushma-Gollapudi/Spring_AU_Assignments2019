import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Employeecomponent from './employee.component.js';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<Employeecomponent />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
