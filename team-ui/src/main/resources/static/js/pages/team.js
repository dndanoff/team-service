class TeamList extends React.Component {
	  constructor(props) {
	    super(props);
	    this.handleSearch = this.handleSearch.bind(this);

	    this.state = {
			employees: [],
			originalEmployees: [],
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
		    		employees: data,
		    		originalEmployees: data
	    		}));
		    })
		    .fail(function() {
		    	if ( console && console.log ) {
		  	      console.log("Service call failed");
		  	    }
		    	
		    	that.setState((prevState, props) => ({
		    		employees: [],
		    		originalEmployees: [],
		    		error:"Failed to retrieve employees"
	    		}));
		    });
	  }

	  componentWillUnmount() {
	    
	  }
	  
	  handleSearch(input){
		input = input.toUpperCase();
		let filteredEmployees = [];
		
		if(this.isEmpty(input)){
			filteredEmployees = this.state.originalEmployees;
		}else{
			for (let i = 0; i < this.state.originalEmployees.length; i++) {
				let employee = this.state.originalEmployees[i];
				let fullName = (employee.firstName+" "+employee.lastName).toUpperCase();
				if(fullName.startsWith(input)){
					filteredEmployees.push(employee);
				}
			}
		}
		
		this.setState((prevState, props) => ({
    		employees: filteredEmployees
		}));
	  }
	  
	  isEmpty(str) {
		  return (!str || 0 === str.length);
	  }
	  	
	  render() {
		let cols = [];
		for (var i = 0; i < this.state.employees.length; i++) {
			cols.push(<Employee key={i} info={this.state.employees[i]}/>);
		}
		  
	    return (
	    	<div id="employees-page">
	    		<Search onSearch={this.handleSearch}/>
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