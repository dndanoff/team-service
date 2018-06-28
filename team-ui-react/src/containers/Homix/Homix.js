import React, { Component } from 'react'
import { Route } from 'react-router-dom';
import MenuHeader from '../../components/Menu/MenuHeader'
import Home from '../../components/Home/Home';
import Members from '../Members/Members';
import newMember from '../../components/Member/NewMember'
import teams from '../Teams/Teams'

class Homix extends Component {
    render() {
      return (  
        <div>
          <MenuHeader/>
          <Route path="/" exact component={Home}/>
          <Route path="/members" exact component={Members}/>
          <Route path="/newMember" exact component={newMember}/>
          <Route path="/teams" exact component={teams}/>
        </div>
  
  
      )
    }
  }

  export default Homix;