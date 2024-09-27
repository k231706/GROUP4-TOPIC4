import React, { useEffect, useState } from "react";
import './Consultation.css';
import axios from "axios";

const Consultation = () => {

    const [request, setRequset] = useState([]);
    const [staffList, setStaffList] = useState([]); // tao ra 1 list de luu nhan vien
    const [isStaffListOpen, setIsStaffListOpen] = useState(false);


    // fetch du lieu api neee ^^
    const fetchRequest = async () => {
        try {
            const respone = await axios.get('http://localhost:8080/manage/consultations');
            setRequset(respone.data); // luu du lieu vao state
        } catch (error) {
            console.error("Error fetching data:", error);
        }
    }


    // fetch du lieu staff
    const fetchStaff = async () => {
        try {
            const respone = await axios.get('http://localhost:8080/staff');
            setStaffList(respone.data);
        } catch (error) {
            console.error("Error fetching staff:", error);
        }
    }
    // su dung khi component dc mount
    useEffect(() => {
        fetchRequest(); // Gọi hàm fetchRequests để lấy dữ liệu khi component được hiển thị
    }, []);  // Mảng rỗng [] nghĩa là hàm chỉ chạy một lần khi component được mount


    const handleAssignStaff = () => {

    }

    // Gọi fetchStaff khi modal mở
    useEffect(() => {
        if (isStaffListOpen === true) {
            fetchStaff();
        }
    }, [isStaffListOpen]);





    return (
        <div className="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Request ID</th>
                        <th>Customer</th>
                        <th>Date</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Assign To</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {request.length > 0 ? (
                        request.map((request, index) => ( // duyet qua tung yeu cau
                            <tr key={request.id}> {/* new 1 dong moi roi su dung rq id lam key ! */}

                                <td>{index}</td>
                                <td>{request.customer}</td>
                                <td>{request.date}</td>
                                <td>{request.phone}</td>
                                <td>{request.address}</td>
                                <td>
                                    <button className="assign-button">Assign</button>
                                </td>
                                <td>{request.status}</td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="7">No requests found</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    )
};
export default Consultation;