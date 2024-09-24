import React, { useState } from 'react';
import './Contact.css';
import Navbar from '../Navbar/Navbar';
import Footer from '../Footer/Footer';
import axios from 'axios';

const Contact = () => {
    const [formData, setFormData] = useState({ // luu thong tin lien he cua khach hang
        service: '',
        fullName: '',
        email: '',
        contactNumber: '',
        message: ''
    });

    const [file, setFile] = useState(null);
    const [submitted, setSubmitted] = useState(false);
    const [error, setError] = useState('');

    // handle gia tri ng dung nhap vao form
    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData(prev => ({ ...prev, [name]: value })); //prev la gia tri ban dau, ..prev la sao chep gia tri hien tai
        // [name]: value cap nhat gia tri cho truong tuong ung (email, name) dua vao thuoc tinh name
    };

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        setFile(file);
    };



    const handleSubmit = async (event) => {
        event.preventDefault(); // ngan chan reload
        setError('');
        setSubmitted(false);

        console.log('form: ', formData);
        console.log('file:', file); // kt file anh

        // tao FormData de gui du lieu va file cho backend

        const dataToSend = new FormData();
        dataToSend.append('service', formData.service);
        dataToSend.append('fullName', formData.fullName);
        dataToSend.append('email', formData.email);
        dataToSend.append('contactNumber', formData.contactNumber);
        dataToSend.append('message', formData.message);
        if (file) {
            dataToSend.append('file', file);
        }

        try {
            const response = await axios.post('http://localhost/8080/api/contact-us', dataToSend);
            console.log(response.data);

            if (response.status === 200) {
                setSubmitted(true);
            }

        } catch (err) {
            setError('FAIL, please try again !!');
            console.error(err);
        }

    };

    return (
        <>
            {/* Navbar ở đầu trang */}
            <Navbar />

            <div className="container mb-5">
                <h1 className="text-center my-4">Contact us</h1>
                <div className="row">
                    <div className="col-md-6">
                        {/* check xem la form dc submit hong */}
                        {submitted ? (
                            // SUCCESS !!!
                            <div className="notification alert-success">
                                <div className="success-icon">
                                    <i className="fa-solid fa-check"></i>
                                </div>
                                <div className="success-text">
                                    SUBMIT SUCCESSFULLY !
                                </div>
                            </div>


                        ) : ( // FAIL !
                            <form onSubmit={handleSubmit} className="bg-light p-4 rounded shadow-lg" >
                                {error && <div className="notification-error aleart-danger">{error}</div>}

                                <div className="form-group mb-6">
                                    <label>Select Service</label>
                                    <select
                                        name="service"
                                        className="form-control"
                                        value={formData.service}
                                        onChange={handleChange}
                                        required
                                    >
                                        <option value="">-- Choose a Service --</option>
                                        <option value="maintenance">Maintenance</option>
                                        <option value="build-koi-pond">Build Koi Pond</option>
                                    </select>
                                </div>
                                <div className="form-group mb-6">
                                    <label>Full Name</label>
                                    <input type="text" className="form-control" name="fullName"
                                        value={formData.fullName}
                                        onChange={handleChange}
                                        required />
                                </div>

                                <div className="form-group mb-6">
                                    <label>Email</label>
                                    <input type="text" className="form-control" name="email"
                                        value={formData.email}
                                        onChange={handleChange}
                                        required />
                                </div>

                                <div className="form-group mb-6">
                                    <label>Contact Number</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="contactNumber"
                                        value={formData.contactNumber}
                                        onChange={handleChange}
                                        required
                                    />
                                </div>

                                <div className="form-group mb-6">
                                    <label>Message</label>
                                    <textarea
                                        className="form-control"
                                        name="message"
                                        rows="4"
                                        value={formData.message}
                                        onChange={handleChange}
                                        required
                                    ></textarea>
                                </div>

                                <button type="submit" className="btn btn-danger w-100 fw-boild py-1 mt-3">
                                    Submit request
                                </button>
                            </form>
                        )}
                    </div>

                    {!submitted && ( // Chỉ hiển thị form upload nếu chưa gửi
                        <div className="col-md-6 bg-light p-4 shadow-lg">
                            <div className="form-group mb-6 text-center ">
                                <label className="label-upload">Upload Image of Your Idea</label>
                                <input
                                    type="file"
                                    name='file'
                                    className="form-control input-upload"
                                    onChange={handleFileChange}
                                    accept="image/*"
                                />
                            </div>
                        </div>
                    )}
                </div >
            </div>

            {/* Footer ở cuối trang */}
            <Footer />
        </>
    );

};

export default Contact;
