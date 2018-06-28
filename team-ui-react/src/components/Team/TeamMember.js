import React from 'react';
import { Card, Image } from 'semantic-ui-react'

const teamMember = ( props ) => {
   return (
      <Card>
      <Card.Content>
      <Image src={ props.photo } />
        <Card.Header>{props.name}</Card.Header>
        <Card.Meta>{ props.position }</Card.Meta>
        <Card.Description> { props.position }is started from {props.date}</Card.Description>
      </Card.Content>
      </Card>
   )};

export default teamMember;