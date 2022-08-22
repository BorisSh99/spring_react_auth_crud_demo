import {Component} from "react";
import CardService from "../services/CardService";

class CardboardComponent extends Component {
    constructor(props) {
        super(props);

        this.state= {
            cards: []
        }

    }

    async componentDidMount() {
        await CardService.getCards().then((res) => {
            this.setState({cards: res.data});
        });
    }

    render() { // TODO Each child in a list should have a unique "key" prop + optimize

        const labels = [...new Set(this.state.cards.flatMap(row => row.label.label))];
        const cards = this.state.cards.map(row => [row.title, row.description, row.label.label, row.dueDate]);
        console.log(cards)

        return (
            labels.map(
                label =>
                    <table className="table">
                        <thead className="thead-dark">
                        <tr>
                            <th scope="col">{label}</th>
                        </tr>
                        </thead>

                        <tbody>
                        <ul className="list-group">
                            <table className="table table-borderless">
                                <thead>
                                <tr>
                                    <th scope="col">Title</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">DueDate</th>
                                </tr>
                                </thead>
                                {
                                    cards.filter(card => card.includes(label)).map(
                                        card =>
                                            <tbody>
                                            <tr>
                                                <td>{card[0]}</td>
                                                <td>{card[1]}</td>
                                                <td>{card[3]}</td>
                                            </tr>
                                            </tbody>
                                    )
                                }
                            </table>
                        </ul>
                        </tbody>
                    </table>
            )

        );
    }
}

export default CardboardComponent;
