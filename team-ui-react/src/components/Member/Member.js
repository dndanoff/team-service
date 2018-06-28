import React from 'react';
import { Card, Icon, Image, Button } from 'semantic-ui-react'

const member = ( props ) => {
    return (
        <Card key={props.id}>
        <Image src={ props.photoUrl } />
        <Card.Content>
          <Card.Header>{ props.firstName }</Card.Header>
          <Card.Meta>{ props.lastName }</Card.Meta>
          <Card.Meta>
          Joined in { props.hireDate }
            </Card.Meta>
          <Card.Description>Daniel is a comedian living in Nashville.</Card.Description>

        </Card.Content>
        <Card.Content extra>
        <Icon name='mail outline'/>
          {props.mail}
        </Card.Content>
        <Card.Content extra>
        <Icon name='phone'/>
          {props.phone}
        </Card.Content>
        <Button negative onClick={props.delete}>Delete</Button>
      </Card>
    )
};


export default member;