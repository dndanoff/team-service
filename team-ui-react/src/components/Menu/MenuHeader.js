import React, { Component } from 'react'
import { Menu, Segment } from 'semantic-ui-react'
import 'semantic-ui-css/semantic.min.css';
import { Link } from 'react-router-dom';

export default class MenuHeader extends Component {
  state = { activeItem: 'team' }

  handleItemClick = (e, { name }) => this.setState({ activeItem: name })

  render() {
    const { activeItem } = this.state

    return (  
      <Segment inverted>
        <Menu inverted secondary>
          <Menu.Item 
          name='home' 
          active={activeItem === 'home'} o
          nClick={this.handleItemClick}>
            <Link to="/"> Home</Link>
          </Menu.Item>

          <Menu.Item
            name='members'
            active={activeItem === 'members'}
            onClick={this.handleItemClick}>
          <Link to="/members"> Members</Link>
          </Menu.Item>

          <Menu.Item
            name='New Member'
            active={activeItem === 'newMember'}
            onClick={this.handleItemClick}>
                    <Link to="/newMember"> New Members</Link>
          </Menu.Item>
        </Menu>
      </Segment>
    )
  }
}