import React, { Component, Fragment } from 'react';
import Member from '../../components/Member/Member';
import axios from '../../axios';
import { Grid } from 'semantic-ui-react';
import NewMember from '../../components/Member/NewMember';

class Members extends Component {

  constructor(props) {
    super(props);
    this.addMember = this.addMember.bind(this);
    this.state = {
      members: [],
      showForm: false
}
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

    addMember(){
      console.log("add member");
      this.setState({
        ...this.state,
        showForm: !this.state.showForm
    });
    }

    render() {
        const members = this.state.members.map(member => {
          return ( 

          <Grid.Column mobile={16} tablet={8} computer={4} key = { member.id }>
          <Member
          id = {member.id}
          photoUrl = { member.photoUrl }
          lastName = { member.lastName }
          hireDate = { member.hireDate }
          firstName = { member.firstName }
          mail = { member.email }
          phone = "088888"/>
          </Grid.Column>);
        })
        return (
          <Fragment>
            <button 
            className="positive ui button" 
            style ={{"margin": "10px"}}
            onClick={this.addMember}>
             Add member</button>
             {this.state.showForm && <NewMember/>}
            <Grid>
            {members}
            </Grid>
          </Fragment>
        );
      }
}

export default Members