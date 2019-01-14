import React, {Component} from 'react';

class Addemployee extends Component{
    data={};
    state={
        shown:false,
        errorMsg: '',
        search_dept: ''
    };

    onClick=()=>{
        
        this.setState({shown:true});
    };

    onCancel=e=>{
        e.preventDefault();
        this.setState({shown:false});
    };

    handleChange= event=>{
        console.log(event.target.value);
        this.data[event.target.id]=event.target.value;
    };

    onadd=e=>{
        e.preventDefault();
        if(this.validate(this.data)){
            this.props.onempadd(this.data);
            console.log("data",this.data);
        }
        
    };

    validate = (data) =>{
        if(data.age <= 18){
            this.setState({errorMsg:'Please add age > 18'});
            return false;
        } 
        else if(data.name.length<10){
            this.setState({errorMsg:'Name should be of atleast 10 characters '});
            return false;
        }
        return true;
    }

   
    render(){
        return (<div>
            <button onClick={this.onClick}> Add employee</button>

            {this.state.errorMsg}
            { this.state.shown &&(
            <div>
                <form>
                    <span>Name: <input type="text" id="name" onChange={this.handleChange}/></span><br/>
                    <span>Age: <input type="text" id="age" onChange={this.handleChange}/></span><br />
                    <span>Location: <input type="text" id="location" onChange={this.handleChange}/></span><br />
                    <select id="dept" onChange={this.handleChange}>
                        { 
                            this.props.departments && this.props.departments.map((dep,i)=>{
                                return(
                                    <option key={dep.name}>{dep.name}</option>
                                );
                            })
                        }
                    </select>
                    <button onClick={this.onadd}> Add </button><br />
                    <button onClick={this.onCancel}> Cancel </button><br />
                </form>
            </div>
            )}
        </div>);
    }
}

export default Addemployee;