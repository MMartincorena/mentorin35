export const fetchRandom = (state) => (dispatch) => {

    dispatch({ type: "view-loading" });
    let v= {list:"0,1,2,3,4"};
    console.log( JSON.stringify(v));
    return fetch(`http://localhost:8080/r`, {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json'
        },
     body: JSON.stringify(v) 
    }).then(response => response.json())
      .then(json => {
          console.log(json);
          dispatch({ type: "random-result", data: json });
          dispatch({ type: "view-loaded" });
        })
}



