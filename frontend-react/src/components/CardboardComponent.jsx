import {useEffect, useState} from "react";
import CardService from "../services/CardService";

function CardboardComponent() { // TODO unique id for label elements
    const [state, setState] = useState({labels: []})

    useEffect(
        () => {
            CardService.getLabels().then((res) => {
                setState({labels: res.data});
            });
        },
        []
    )

    return (
        state.labels.map(
            label =>
                <table className="table">
                    <thead className="thead-dark">
                    <tr>
                        <th scope="col">{label.name}</th>
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
                                label.cardList.map(card =>
                                    <tbody>
                                    <tr>
                                        <td>{card.title}</td>
                                        <td>{card.description}</td>
                                        <td>{card.dueDate}</td>
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

export default CardboardComponent;