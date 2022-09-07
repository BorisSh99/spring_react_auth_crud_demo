import Form from 'react-bootstrap/Form';
import {Button} from "react-bootstrap";
import {useForm} from "react-hook-form";
import CardService from "../services/CardService";

function CreateCardComponent() { //TODO Errors handling

    const {
        register,
        handleSubmit,
        watch,
        formState: { errors }
    } = useForm();

    const onSubmit = (data) => {
        console.log(data);
        CardService.postCard(JSON.stringify(data))
    };

    return (
        <Form onSubmit={handleSubmit(onSubmit)}>

            <Form.Group className="mb-3" controlId="title">
                <Form.Label>Title</Form.Label>
                <Form.Control type="text" placeholder="Title" {...register("title", {required: true})} />
            </Form.Group>

            <Form.Group className="mb-3" controlId="description">
                <Form.Label>Description</Form.Label>
                <Form.Control as="textarea" placeholder="Description" {...register("description", {required: true})} />
            </Form.Group>

            <Form.Group className="mb-3" controlId="labelName">
                <Form.Label>Label</Form.Label>
                <Form.Control type="text" placeholder="Label" {...register("labelName", {required: true})} />
            </Form.Group>

            <Form.Group className="mb-3" controlId="dueDate">
                <Form.Label>DueDate</Form.Label>
                <Form.Control type="date" placeholder="DueDate" {...register("dueDate", {required: true})} />
            </Form.Group>

            <Button variant="primary" type="submit">
                Submit
            </Button>

        </Form>
    );
}
export default CreateCardComponent;