import React from 'react'
import { connect } from 'react-redux';


const Result = (props) => {
  
  console.log(props.result);
  return <div>
     {props.result && 'Lista: '+ props.result} 
  </div>
}


const stateMapToPros = state => {
  return {
    result: state.random.result?.randomList
  }
}


export default connect(stateMapToPros)(Result)
