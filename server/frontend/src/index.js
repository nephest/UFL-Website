import React, { Component } from 'react';
import ReactDOM from 'react-dom/client';

class TestComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {string: ""};
    }

    componentDidMount() {
        this.loadString();
    }

    loadString() {
        this.setState({string: "Loading..."});
        fetch('/test/string')
            .then(response => response.text())
            .then(data => this.setState({string: "Loaded test string from the backend: " + data}))
            .catch(e => {
                this.setState({string: "Failed to load test string from the backend"});
                console.log(e);
            });
    }

    render() {
        return (<p>{this.state.string}</p>)
    }
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <h1>Hello UFL!</h1>
    <TestComponent/>
  </React.StrictMode>
);