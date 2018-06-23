class EmployeeDetailsPage extends React.Component {
	  constructor(props) {
	    super(props);

	    this.state = {
	    	employee:{
	    		title:{},
	    		contacts:[]
	    	},
	    	error:""
		};
	  }

	  componentDidMount() {
		  var that = this;
		  
		  if(!this.props.match.params.id){
			  this.setState((prevState, props) => ({
		    		error:"Id is not present"
    		  }));
			  return;
		  }
		  
		  $.ajax({
		        url: "/api/members/"+that.props.match.params.id,
		    })
		    .done(function(data) {
		    	that.setState((prevState, props) => ({
		    		employee: data
	    		}));
		    })
		    .fail(function() {
		    	if ( console && console.log ) {
		  	      console.log("Service call failed");
		  	    }
		    	
		    	that.setState((prevState, props) => ({
		    		error:"Failed to retrieve employee"
	    		}));
		    });
	  }

	  componentWillUnmount() {
	    
	  }
	  	
	  render() {
		  if(!(this.state.error || 0 === this.state.error.length)){
			  return (
				<div id="error" class="alert alert-warning" role="alert">
	  				{this.state.error}
	    		</div>
    		);
		  }
		  
		  let contacts = [];
	  		for (var i = 0; i < this.state.employee.contacts.length; i++) {
	  			let value = <span>{this.state.employee.contacts[i].value}</span>;
	  			if("E-MAIL" == this.state.employee.contacts[i].name.toUpperCase()){
	  				value = <a href={"mailto:"+this.state.employee.contacts[i].value}>{this.state.employee.contacts[i].value}</a>;
	  			}else if("MOBILE" == this.state.employee.contacts[i].name.toUpperCase()){
	  				value = <a href={"tel:"+this.state.employee.contacts[i].value}>{this.state.employee.contacts[i].value}</a>;
	  			}
	  			
	  			contacts.push(
						<div class="row" key={this.state.employee.contacts[i].id}>
					    	<div class="col">
					    		{this.state.employee.contacts[i].name}
					    	</div>
					    	<div class="col-10">
					    		{value}
					    	</div>
				    	</div>
	  			);
	  		}
		  
	    return (
	    	<div id="employee-page">
		    	<div id="employee" class="list-group list-group-flush">
			    	<div class="list-group-item flex-column align-items-start">
			    		<img class="img-thumbnail" src={this.state.employee.photoUrl} alt={this.state.employee.firstName+" "+this.state.employee.lastName+" photo"}/>
			    		<h2>{this.state.employee.firstName+" "+this.state.employee.lastName}</h2>
			    		<p>{this.state.employee.title.description}</p>
			    	</div>
			    	<div class="list-group-item flex-column align-items-start">
				    	{contacts}
			    	</div>
			    </div>
			</div>
	    );
	  }
}



