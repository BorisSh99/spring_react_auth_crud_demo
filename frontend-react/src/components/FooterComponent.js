import {Component} from "react";

class FooterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div className="container">
                <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
                    <div className="col-md-4 d-flex align-items-center">

                        <span className="text-muted">© 2022 Company, Inc</span>
                    </div>
                </footer>
            </div>
        )
    }
}

export default FooterComponent
