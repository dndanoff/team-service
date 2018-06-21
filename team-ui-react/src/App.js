import React, { Component } from 'react';

import { BrowserRouter } from 'react-router-dom';
import Homix from './containers/Homix/Homix'
import 'semantic-ui-css/semantic.min.css';

class App extends Component {




  render() {
    return (<BrowserRouter>
      <Homix/>
      </BrowserRouter>
    );
  }
}

export default App;
