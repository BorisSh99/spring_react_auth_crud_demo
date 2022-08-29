import {useEffect, useState} from "react";
import {useForm} from "react-hook-form";

function CreateCardComponent() {
    const [state, setState] = useState({
        title: '',
        description: '',
        label: '',
        dueDate: null,
        successfulSave: true,
        showAlert: false,
    })

    const {
        register,
        handleSubmit,
        watch,
        formState: { errors }
    } = useForm();

    const onSubmit = (data) => {
        console.log(data);
    };


    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            {/* register your input into the hook by invoking the "register" function */}
            <input defaultValue="test" {...register("example")} />

            {/* include validation with required or other standard HTML validation rules */}
            <input {...register("exampleRequired", { required: true })} />
            {/* errors will return when field validation fails  */}
            {errors.exampleRequired && <p>This field is required</p>}

            <input type="submit" />
        </form>
    );

}

export default CreateCardComponent;