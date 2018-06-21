import React, { Component } from 'react'
import { Route } from 'react-router-dom';
import MenuHeader from '../../components/Menu/MenuHeader'
import Home from '../../components/Home/Home';
import Members from '../Members/Members';
import newMember from '../../components/Member/NewMember'

class Homix extends Component {
    render() {
      return (  
        <div>
          <MenuHeader/>
          <Route path="/" exact component={Home}/>
          <Route path="/members" exact component={Members}/>
          <Route path="/newMember" exact component={newMember}/>
        </div>
  
  
      )
    }
  }

  export default Homix;