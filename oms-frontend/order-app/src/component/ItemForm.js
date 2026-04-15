import { useState } from "react";
import axios from "axios";

function ItemForm() {
    const [formData, setFormData] = useState({
        item: "",
        price: ""
    });
    const [items, setItems] = useState([]);
    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };
    const addItem = () => {
        if (formData.item.trim() === "" || formData.price === "") {
            return;
        }
        setItems([
            ...items,
            formData
        ]);
        setFormData({
            item: "",
            price: ""
        });
    };
    const handleSubmit = async (event) => {
        event.preventDefault();
        const validItems = items.filter(
            (data) =>
                data.item.trim() !== "" &&
                data.price !== ""
        );
        const orderData = {
            orderLines: validItems
        };
        await axios.post("http://localhost:8080/order", orderData);
        setItems([]);
        setFormData({
            item: "",
            price: ""
        });
    };
    return (
        <>
            <div className="container">
                <form className="form-box" onSubmit={handleSubmit}>
                    <div className="inputs">
                        <input
                            type="text"
                            name="item"
                            className="input-field"
                            placeholder="Enter Item Name"
                            value={formData.item}
                            onChange={handleChange}
                        />
                        <input
                            type="number"
                            name="price"
                            className="input-field"
                            placeholder="Enter Price"
                            value={formData.price}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="buttons">
                        <button type="button" onClick={addItem} className="btn add-button">
                            Add Item
                        </button>
                        <button type="submit" className="btn submit-button">
                            Submit
                        </button>
                    </div>
                </form>
                {items.map((data, index) => (
                    <div key={index} className="inputs">
                        {data.item} - {data.price}
                    </div>
                ))}
            </div>
        </>
    );
}

export default ItemForm;