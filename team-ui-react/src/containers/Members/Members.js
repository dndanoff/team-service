import React, { Component } from 'react';
import Member from '../../components/Member/Member';
import axios from '../../axios';
import { Grid } from 'semantic-ui-react';

class Members extends Component {
    state = {
        members: []
      }
      componentDidMount() {
          console.log("--------------->");
        axios.get('/members?pageSize=25')
        .then(response =>{
          this.setState({members: response.data});
          console.log(response);
        })
        .catch(error => {
          console.log(error);
        })
      }

    render() {
        const members = this.state.members.map(member => {
          return ( 
          <Grid.Column mobile={16} tablet={8} computer={4}>
          <Member
          key = { member.id }
          photoUrl = { member.photoUrl }
          lastName = { member.lastName }
          hireDate = { member.hireDate }
          firstName = { member.firstName }
          mail = { member.email }
          phone = "088888"/>
          </Grid.Column>);
        })
        return (
            <Grid>
            
            {members}
            </Grid>
        );
      }
}

export default Members