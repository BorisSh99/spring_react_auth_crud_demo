import {useEffect, useState} from "react";
import CardService from "../services/CardService";
import {Card, ListGroup} from "react-bootstrap";
import './CardboardComponent.css';

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
        <div className={"test"}>
            <ListGroup horizontal={true}>
                {
                    state.labels.map(
                        label =>
                            <ListGroup.Item key={label.id}>
                                <h3>{label.name}</h3>
                                <ListGroup > {/*style={{overflowY: 'scroll'}}*/}
                                    {
                                        label.cardList.map(card =>

                                            <Card key={card.id} style={{marginTop: '10px',}}>
                                                <Card.Body>
                                                    <Card.Title>{card.title}</Card.Title>
                                                    <Card.Subtitle className="mb-2 text-muted">{card.dueDate}</Card.Subtitle>
                                                    <Card.Text>
                                                        {card.description}
                                                    </Card.Text>
                                                    <Card.Link href="#">Card Link</Card.Link>
                                                    <Card.Link href="#">Another Link</Card.Link>
                                                </Card.Body>
                                            </Card>

                                        )
                                    }
                                </ListGroup>
                            </ListGroup.Item>
                    )
                }
            </ListGroup>
        </div>



    );
}

export default CardboardComponent;