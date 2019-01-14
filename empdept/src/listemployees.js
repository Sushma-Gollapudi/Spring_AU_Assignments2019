import React, {Component} from 'react';

class Listemployees extends Component{

    render(){
    
        console.log("employees",this.props.employees);
        
    
   
        return (
            <div>
            <h2> list of employess </h2>
            <table border="1px solid black">
                        <th>
                            <td> Name</td>
                            <td>Age</td>
                            <td> Location</td>
                            <td> Dpartment</td>
                        </th>
            </table>
            {this.props.employees && this.props.employees.map((employee,i)=>{
                return (
                    <table border="1px solid black">
                        <tr key={employee.name}>
                            <td> {employee.name} </td>
                            <td> {employee.age}</td>
                            
                            <td> {employee.location}</td>
                            <td> {employee.dept}</td>
                        </tr>
                    </table>

               
                );
            })}
            </div>
            );
    }
}

export default Listemployees;