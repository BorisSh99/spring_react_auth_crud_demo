import Form from 'react-bootstrap/Form';
import {Button, Dropdown, DropdownButton, InputGroup} from "react-bootstrap";
import CardService from "../services/CardService";
import {useEffect, useState} from "react";

function CreateCardComponent() { //TODO Errors handling

    const [stateLabels, setLabels] = useState({labels: []})

    const [stateCurrentTitle, setCurrentTitle] = useState({currentTitle: ""})
    const [stateCurrentDescription, setCurrentDescription] = useState({currentDescription: ""})
    const [stateCurrentLabel, setCurrentLabel] = useState({currentLabel: ""})
    const [stateCurrentDueDate, setCurrentDueDate] = useState({currentDueDate: ""})


    useEffect(
        () => {
            CardService.getLabels().then((res) => {
                setLabels({labels: res.data});
            });
        },
        []
    )

    const handleSubmit = async (_event) => {
        let cardData = {
            title: stateCurrentTitle.currentTitle,
            description: stateCurrentDescription.currentDescription,
            labelName: stateCurrentLabel.currentLabel,
            dueDate: stateCurrentDueDate.currentDueDate
        }
        alert(JSON.stringify(cardData))
        await CardService.postCard(cardData) //TODO JSON.stringify
    };

    const handleTitleChange = (event) => {
        setCurrentTitle({currentTitle: event.target.value})
    }

    const handleDescriptionChange = (event) => {
        setCurrentDescription({currentDescription: event.target.value})
    }

    const handleLabelSelect = (eventKey, _event) => {
        setCurrentLabel({currentLabel: eventKey});
    };

    const handleLabelChange = (event) => {
        setCurrentLabel({currentLabel: event.target.value})
    }

    const handleDueDateChange = (event) => {
        setCurrentDueDate({currentDueDate: event.target.value})
    }

    return (
        <div className="container w-25">
            <h3>Create new card</h3>
            <Form onSubmit={handleSubmit}>

                <Form.Group className="mb-3" controlId="title">
                    <Form.Label>Title</Form.Label>
                    <Form.Control type="text" placeholder="Title" value={stateCurrentTitle.currentTitle} onChange={handleTitleChange}  />
                </Form.Group>

                <Form.Group className="mb-3" controlId="description">
                    <Form.Label>Description</Form.Label>
                    <Form.Control as="textarea" placeholder="Description" value={stateCurrentDescription.currentDescription} onChange={handleDescriptionChange}/>
                </Form.Group>

                <Form.Label>Label</Form.Label>
                <InputGroup className="mb-3" controlid="labelName">
                    <Form.Control type="text" placeholder="Label" value={stateCurrentLabel.currentLabel} onChange={handleLabelChange} />
                    <DropdownButton
                        variant="outline-secondary"
                        title=""
                        id="input-group-dropdown"
                        align="end"
                        onSelect={handleLabelSelect}
                    >
                        {
                            stateLabels.labels.map(
                                label =>
                                    <Dropdown.Item eventKey={label.name} key={label.id}>{label.name}</Dropdown.Item>
                            )
                        }
                    </DropdownButton>
                </InputGroup>

                <Form.Group className="mb-3" controlId="dueDate">
                    <Form.Label>DueDate</Form.Label>
                    <Form.Control type="date" value={stateCurrentDueDate.currentDueDate} onChange={handleDueDateChange}/>
                </Form.Group>

                <Button variant="primary" type="submit">
                    Submit
                </Button>

            </Form>
        </div>
    );
}
export default CreateCardComponent;