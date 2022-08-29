import {useEffect, useState} from "react";
import CardService from "../services/CardService";

function CardboardComponent() {
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
                <table className="table" key={label.id}>
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
                                    <tbody key={card.id}>
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