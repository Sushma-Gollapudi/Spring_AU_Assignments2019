import React, {Component} from 'react';

class Adddepartment extends Component{
    data={};
    state={
        shown:false
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
        this.props.ondeptadd(this.data);
        console.log("data",this.data);
        
    };

    render(){
        return (<div>
            <br /><br />
            <button onClick={this.onClick}> Add department</button>
            { this.state.shown &&(
            <div>
                <form>
                    <span>Name: <input type="text" id="name" onChange={this.handleChange}/></span><br/>
                    <span>Description: <input type="textarea" id="desc" onChange={this.handleChange}/></span><br />
                    <button onClick={this.onadd}> Add</button><br/>
                    <button onClick={this.onCancel}> Cancel </button><br />
                </form>
            </div>
            )}
        </div>);
    }
}

export default Adddepartment;