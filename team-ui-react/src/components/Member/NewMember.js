import React,  { Component } from 'react'
import { Button, Form, Segment } from 'semantic-ui-react'
import axios from '../../axios'

class NewMember extends Component {

    state = {
        fistName: '',
        lastName: '',
        email: '',
        hireDate: '',
        photo: '',
    }

    postDataHandler = () => {
        const request = {
            'firstName': this.state.fistName,
            'lastName': this.state.lastName,
            'email': this.state.email,
           'hireDate': this.state.hireDate,
            'photo': this.state.photo,
        }
        // https://dreamix.eu/images/team/Angel_Gruev_Dreamix.jpg
        console.log(request);
        axios.post('/members', request)
        .then(response =>{
            console.log(response);
        })
        
    }

    render() {
        return (
            <Segment inverted>
                <Form inverted>
                <Form.Group widths='equal'>
                    <Form.Input 
                    fluid label='First name' 
                    placeholder='First name' 
                    value={this.state.fistName}
                    onChange={(event) => this.setState({fistName: event.target.value})} />
                    <Form.Input 
                    fluid label='Last name' 
                    placeholder='Last name' 
                    value={this.state.lastName}
                    onChange={(event) => this.setState({lastName: event.target.value})}/>
                </Form.Group>
                <Form.Group widths='equal'>
                    <Form.Input 
                    fluid label='email' 
                    placeholder='Email' 
                    value={this.state.email}
                    onChange={(event) => this.setState({email: event.target.value})}/>
                    <Form.Input 
                    fluid label='hireDate' 
                    placeholder='Hire Date' 
                    value={this.state.hireDate}
                    onChange={(event) => this.setState({hireDate: event.target.value})}/>
                    <Form.Input 
                    fluid label='photo' 
                    placeholder='Photo' 
                    value={this.state.photo}
                    onChange={(event) => this.setState({photo: event.target.value})}/>
                </Form.Group>

                <Form.Checkbox label='I agree to the Terms and Conditions' />
                <Button type='submit' onClick={this.postDataHandler}>Submit</Button>
                </Form>
            </Segment>
        );
      }
}

export default NewMember;