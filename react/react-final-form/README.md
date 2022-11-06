
# React-final-form

When we create a form with react-final-form, we has access and change the values within the child component (the component within the Form) using `useFormState` and `useForm`.

**Form component**
```js
import { Form } from 'react-final-form';

const MyReactComponent = () => {

    const myInitialValues = ...code...

    return (
        <Form
            initialValues={myInitialValues}
            onSubmit={onSubmitA}
            initialValuesEqual={isEqual}
            render={({ handleSubmit }) => (
                <form onSubmit={handleSubmit} autoComplete="off">
                    <MyOtherReactComponent />
                </form>
            )}
        />
    )
}
```

**Child component**
```js
import { useForm, useFormState } from 'react-final-form';

const MyOtherReactComponent = () => {
    // function to change values in the form
    const { change } = useForm();
    // Get the form values "values"
    const { values } = useFormState();

    // Example of trigger when a value change
    useEffect(() => {
        console.log("myValue changed!")
    }, [values.myValue])

    return (
        ...
    )
}


