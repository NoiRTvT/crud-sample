import React from 'react'
import {Navigate, Route, Routes} from 'react-router-dom'
import UsersPage from './pages/users'
import './App.css'
import 'antd/dist/antd.min.css'

function App() {
    return (
        <Routes>
            <Route
                index
                element={<Navigate to='/users'/>}
            />
            <Route
                path='/users'
                element={<UsersPage/>}
            />
            {/*<Route*/}
            {/*  path='/users/:userId'*/}
            {/*  element={<UserForm />}*/}
            {/*/>*/}
        </Routes>
    )
}

export default App
