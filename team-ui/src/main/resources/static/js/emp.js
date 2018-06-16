var BrowserRouter = ReactRouterDOM.BrowserRouter;
var Route = ReactRouterDOM.Route;
var NavLink = ReactRouterDOM.NavLink;

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
    	<BrowserRouter>
			<div class="container">
				<Menu />
				<div className="content">
		            <Route exact path="/" render={(props) => <TeamList {...props} pageSize={15}/>}/>
	            </div>
			</div>
		</BrowserRouter>
    );
  }
}

class Menu extends React.Component {
	  constructor(props) {
	    super(props);
	    this.state = {};
	  }

	  render() {
	    return (
	    	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
				<NavLink className="navbar-brand" to="/">Dreamix</NavLink>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#menu" aria-controls="menu" aria-expanded="false"
					aria-label="Toggle menu">
					<span class="navbar-toggler-icon"></span>
				</button>
				
				<div class="collapse navbar-collapse" id="menu">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><NavLink className="nav-link" to="/">Team </NavLink></li>
					</ul>
				</div>
			</nav>
	    );
	  }
}

class TeamList extends React.Component {
	  constructor(props) {
	    super(props);
	    this.state = {
			employees: [],
			pageNumber:0,
			error: ""
		};
	  }

	  componentDidMount() {
		  var that = this;
		  
		  $.ajax({
		        url: "/api/members?pageSize="+that.props.pageSize+"&pageNumber="+that.state.pageNumber,
		    })
		    .done(function(data) {
		    	that.setState((prevState, props) => ({
		    		employees: data
	    		}));
		    })
		    .fail(function() {
		    	if ( console && console.log ) {
		  	      console.log("Service call failed");
		  	    }
		    	
		    	that.setState((prevState, props) => ({
		    		employees: [],
		    		error:"Failed to retrieve employees"
	    		}));
		    });
	  }

	  componentWillUnmount() {
	    
	  }
	  	
	  render() {
		let cols = [];
		for (var i = 0; i < this.state.employees.length; i++) {
			cols.push(<Employee key={i} info={this.state.employees[i]}/>);
		}
		  
	    return (
	    	<div id="employees-page">
	    		<div id="error" class="row">
	    			{this.state.error}
	    		</div>
		    	<div id="employees" class="row">
					<div class="card-columns">
						{cols}
					</div>
				</div>
			</div>
	    );
	  }
}

class Employee extends React.Component {
	  constructor(props) {
	    super(props);
	    this.state = {};
	  }

	  render() {
	    return (
    		<div class="card">
			  <img class="card-img-top" src={this.props.info.photoUrl} alt={this.props.info.firstName+" "+this.props.info.lastName+" photo"}/>
			  <div class="card-body">
			    <h5 class="card-title">{this.props.info.firstName+" "+this.props.info.lastName}</h5>
			    <p class="card-text">{this.props.info.email}</p>
			    <a href="#" class="btn btn-primary">More</a>
			  </div>
			</div>
	    );
	  }
}

ReactDOM.render(
		<App />,
		document.getElementById('react-root')
);