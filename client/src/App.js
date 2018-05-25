import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Index from './index/index';
import $ from 'jquery';

window.jQuery = $;
window.$ = $;
global.jQuery = $;

class App extends Component {
  render() {
    return (
      <div className="App">
        <Index/>
      </div>
    );
  }
}

export default App;
