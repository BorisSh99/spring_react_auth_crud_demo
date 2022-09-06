import {useEffect, useState} from "react";
import {Controller, useForm} from "react-hook-form";
import DatePicker from "react-datepicker";
import CardService from "../services/CardService";

import 'react-datepicker/dist/react-datepicker.css';

function CreateCardComponent() {
    const [state, setState] = useState({
        title: '',
        description: '',
        label: '',
        dueDate: null,
        successfulSave: true,
        showAlert: false,
        labels: [],
    })

    const {
        control,
        register,
        handleSubmit,
        watch,
        formState: { errors }
    } = useForm();

    useEffect(
        () => {
            CardService.getLabels().then((res) => {
                setState({labels: res.data});
            });
        },
        []
    )

    const onSubmit = (data) => {
        console.log(data);
        // CardService.postCard(JSON.stringify(data))
    };


    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            {/* register your input into the hook by invoking the "register" function */}
            <input placeholder={"Title"} {...register("title", {required: true})} />

            {/* include validation with required or other standard HTML validation rules */}
            <input placeholder={"Description"} {...register("description", { required: true })} />
            {/* errors will return when field validation fails  */}
            <input placeholder={"Label"} {...register("label", { required: true })} />
            {/*<input placeholder={"Due date"} {...register("dueDate", { required: true })} />*/}
            <Controller
                control={control}
                name="dueDate"
                render={({ field }) => (
                    <DatePicker
                        onChange={(date) => field.onChange(date)}
                        selected={field.value}
                        dateFormat="yyyy-MM-dd"
                        placeholderText="YYYY-MM-DD"
                    />
                )}
            />


            {errors.exampleRequired && <p>This field is required</p>}

            <input type="submit" />
        </form>
    );

}

export default CreateCardComponent;