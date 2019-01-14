import React, {Component} from 'react';
import Listemployees from './listemployees';

class Searchemployees extends Component{
    emps=[];
    data={};
    state={
        emplys:[]
    };

    handleChange= event=>{
        console.log(event.target.value);
        this.emps=[];
        //this.setState({emps:[]});
        this.data[event.target.id]=event.target.value;
        event.preventDefault();
        var k=0;
        for( var i=0;i<this.props.employees.length;i+=1)
        {
           if(this.data[event.target.id]===this.props.employees[i].dept)
           {
                this.emps[k]=this.props.employees[i];
                k+=1;
           }
        }
        this.setState({emplys: this.emps});
        console.log("Employees",this.emps);
    };

    
    render(){
        return (
            
                <form>
                    <br/>
                    <br/>
                    <h1>Search:</h1>
                    
                    <select id="dept" onChange={this.handleChange}>
                        
                        { 
                            this.props.departments && this.props.departments.map((dep,i)=>{
                                return(
                                    <option key={dep.name}>{dep.name}</option>
                                );
                            })
                        }
                    </select>
                    <Listemployees employees={this.state.emplys} />
                </form>
                
        );
    }

}

export default Searchemployees;
