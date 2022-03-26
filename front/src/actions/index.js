

export const fetchRandom = (state) => (dispatch) => {

    dispatch({ type: "view-loading" });
 
    return fetch(`http://localhost:8080/r`, {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json'
        },
     body: JSON.stringify({list: state}) 
    }).then(response => response.json())
      .then(json => {
          dispatch({ type: "random-result", data: json });
          dispatch({ type: "view-loaded" });
        })
}



