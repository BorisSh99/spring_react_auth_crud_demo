import {Component} from "react";
import {Button, Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";

class HeaderComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {};
    }

    render() {
        return (
            <div className="container w-100">
                <Navbar className="d-flex py-3 align-content-center">
                    <Navbar.Brand>Kanban Board</Navbar.Brand>
                    <Navbar.Collapse className="">
                        <Nav className="me-auto">
                            <Link to="/"><Button variant="primary">CARDBOARD</Button></Link>
                            <Link to="/new"><Button variant="success">NEW CARD</Button></Link>
                            {/*<Link
                                className="link-secondary text-decoration-none ButtonMarginRight"
                                to="/cards"
                            >
                                <button type="button" className="btn btn-dark">
                                    CARDS
                                </button>
                            </Link>*/}
                        </Nav>

                    </Navbar.Collapse>
                </Navbar>
                <hr className="m-0 p-0 mb-3" />
            </div>
        );
    }
}

export default HeaderComponent;

