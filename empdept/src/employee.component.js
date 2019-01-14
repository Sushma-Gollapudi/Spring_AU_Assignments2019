import React, {Component} from 'react';
import Addemployee from './addemployee';
import Listemployees from './listemployees';
import Adddepartment from './adddepartment';
import Listdepartments from './listdepartments';
import Searchemployees from './searchemployees';

class Employeecomponent extends Component{

    state={
        employees:[
            {
                name: "raviteja",
                lname: "V",
                age: 21,
                dept: "it",
                designation: "intern",
                location: "Mangalore, Karnataka,India, Asia, World, Earth"
              },
              {
                name: "Devraj",
                lname: "M",
                age: 21,
                dept: "hr",
                designation: "intern",
                location: "Bangalore,Karnataka,India, Asia, World, Earth"
              },
              {
                name: "kumar",
                lname: "santanu",
                age: 26,
                dept: "it",
                designation: "intern",
                location: "Patna, Bihar,India, Asia, World, Earth"
              },
              {
                name: "Sushma",
                lname: "G",
                age: 21,
                dept: "manager",
                designation: "intern",
                location: "Mysore,India, Asia, World, Earth"
              }
            ],

        departments: [
            {
                name: "hr",
                desc: "human resources"
            },
            {
                name: "it",
                desc: "tech"
            },
            {
                name: "manager",
                desc: "znxcgvh"
            }

        ]
        };

        onemployeeadded=newemployeedata=>{
            console.log("new data",newemployeedata);
            let employees=[...this.state.employees];
           let newemp={...newemployeedata};
           employees.push(newemp);
        //    employees.push(newemployeedata);
            this.setState({employees: employees});
        };

        onedeptadded=newdeptdata=>{
            console.log("new data",newdeptdata);
            let departments=[...this.state.departments];
            //let newdep=[...newdeptdata];
            //departments.push(newdep);
            departments.push(newdeptdata);
            this.setState({departments:departments});
        };

        
    

    render(){
        return (
            <React.Fragment>
                <Addemployee onempadd={this.onemployeeadded} departments={this.state.departments}/>
                <Listemployees employees={this.state.employees} />
                <Searchemployees employees={this.state.employees} departments={this.state.departments} />
                <Adddepartment ondeptadd={this.onedeptadded} /> 
                <Listdepartments departments={this.state.departments}/>
            </React.Fragment>
            
        
        );
    }
}

export default Employeecomponent;