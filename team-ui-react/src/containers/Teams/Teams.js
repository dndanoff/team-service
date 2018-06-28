import React, { Component, Fragment } from 'react';
import { Card } from 'semantic-ui-react';
import axios from '../../axios';
import TeamInfo from '../../components/Team/TeamInfo';
import TeamMember from '../../components/Team/TeamMember';



class Teams extends Component {
    state = {
        showForm: false,
        teams: []
    }

    componentDidMount() {
      axios.get('/teams?pageSize=25')
      .then(response =>{
        this.setState({teams: response.data});
        console.log(response);
      })
      .catch(error => {
        console.log(error);            
      })
    }
    render() {
        const teams = this.state.teams.map( team =>{
           return (
               <Fragment key= {team.id}>
                    <TeamInfo name={team.name}/>
                    <Card.Group               
                    style={{
                        "margin": "13px"
                    }}>
                    {team.members.map(member =>{
                    return ( <TeamMember
                        photo={member.phtoUrl}
                        position="DEV"
                        name={member.firstName + " " + member.lastName}
                        date={member.hireDate}
                        />)
                    })}
                    </Card.Group>
               </Fragment>

           )
            
        })
        return <Fragment>

        {teams}
        </Fragment>
    }
}

export default Teams;