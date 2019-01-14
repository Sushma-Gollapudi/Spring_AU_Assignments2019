import React, {Component} from 'react';

class Listdepartments extends Component{

    render(){
    
        console.log("departments",this.props.departments);
        
    
   
        return (
            <div>
            <h2> list of departments </h2>
            <table border="1px solid black">
                        <th>
                            <td> Name</td>
                            <td>Description</td>
                            
                        </th>
            </table>
            {this.props.departments && this.props.departments.map((department,i)=>{
                return (
                    <table border="1px solid black">
                        <tr key={department.name}>
                            <td> {department.name} </td>
                            <td> {department.desc}</td>
                            
                        </tr>
                    </table>

               
                );
            })}
            </div>
            );
    }
}

export default Listdepartments;