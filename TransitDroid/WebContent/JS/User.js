var User = Class.create();
User.prototype = {
		initialize: function(firstName, lastName, username, password){
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
		},
		getFirstName: function(){
			return this.firstName;
		},
		getLastName: function(){
			return this.lastName;
		},
		getUsername: function(){
			return this.username;
		},
		getpassword: function(){
			return this.password;
		},
		setFirstName: function(fn){
			this.firstName = fn;
		},
		setLastName: function(ls){
			this.lastName = ls;
		},
		setUsername: function(un){
			this.username = un;
		},
		setpassword: function(pw){
			this.password = pw;
		}
};