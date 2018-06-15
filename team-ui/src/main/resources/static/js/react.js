$.ajax({
        url: "/api/members"
    }).then(function(members) {
    });

function App(props) {
	return <div>
				<Menu />
				<TeamPage />
			</div>;
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
					<li class="nav-item"><a class="nav-link" href="#">Team </a></li>
					<li class="nav-item"><a class="nav-link" href="#">Administration</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contacts</a></li>
				</ul>
			</div>
		</nav>;
}

function TeamPage(props) {
	$.ajax({
        url: "/api/members"
    }).then(function(members) {
    });
	
	return <div></div>;
}


const app = <App />;
var root = document.getElementById('react-root');

ReactDOM.render(
		app,
		root
);