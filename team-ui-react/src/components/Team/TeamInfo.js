import React from 'react';
import { Header } from 'semantic-ui-react'

const teamInfo = ( props ) => {
    return (
    <Header size='medium'>{props.name}</Header>
    )
};

export default teamInfo;
