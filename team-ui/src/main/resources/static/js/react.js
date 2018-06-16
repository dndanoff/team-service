var BrowserRouter = ReactRouterDOM.BrowserRouter;
var Route = ReactRouterDOM.Route;
var NavLink = ReactRouterDOM.NavLink;

function App(props) {
	let currentPage=0;
	
	function getMembers(pageNumber){
		let members = [];
		let pageSize=15;
		$.ajax({
	        url: "/api/members?pageSize="+pageSize+"&pageNumber="+pageNumber,
	        async:false
	    })
	    .done(function(data) {
	    	members=data;
	    })
	    .fail(function() {
	    	if ( console && console.log ) {
    	      console.log("Service call failed");
    	    }
	    });
		
		return members;
	}
	
	let members = getMembers(currentPage);
	
	return 	<BrowserRouter>
				<div class="container">
					<Menu />
					<div className="content">
			            <Route exact path="/" component={TeamPage} members={members}/>
			            <Route path="/administration" component={AdministrationPage}/>
			            <Route path="/contacts" component={ContactsPage}/>
		            </div>
				</div>
			</BrowserRouter>;
}

function Menu(props) {
  return <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
			<a class="navbar-brand" href="#">Dreamix</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#menu" aria-controls="menu" aria-expanded="false"
				aria-label="Toggle menu">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><NavLink className="nav-link" to="/">Team </NavLink></li>
					<li class="nav-item"><NavLink className="nav-link" to="/administration">Administration</NavLink></li>
					<li class="nav-item"><NavLink className="nav-link" to="/contacts">Contacts</NavLink></li>
				</ul>
			</div>
		</nav>;
}

function TeamPage(props) {
	let body=null;
	let members = props.members;
	
	if(typeof myVar != "undefined"){
		let cols = [];
		for (var i = 0; i < members.length; i++) {
			cols.push(<Member key={i} info={members[i]}/>);
		}
		
		body = 	<div class="row">
					<div class="card-columns">
					{cols}
					</div>
				</div>;
	}

	return body;
}

function Member(props){
	return <div class="card">
			  <img class="card-img-top" src={props.info.photoUrl} alt={props.info.firstName+" "+props.info.lastName+" photo"}/>
			  <div class="card-body">
			    <h5 class="card-title">{props.info.firstName+" "+props.info.lastName}</h5>
			    <p class="card-text">{props.info.email}</p>
			    <a href="#" class="btn btn-primary">More</a>
			  </div>
			</div>;
}

function AdministrationPage(props) {
	return <div>Office</div>;
}

function ContactsPage(props) {
	return <div>Address</div>;
}

ReactDOM.render(
		<App />,
		document.getElementById('react-root')
);