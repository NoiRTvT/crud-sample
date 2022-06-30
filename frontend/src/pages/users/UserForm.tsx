import {Form, Input, Layout, Spin, Typography} from 'antd'
import {useParams} from 'react-router-dom'
import {useGet} from '../../utils'
import {UserResponse} from './types'
import {useEffect} from 'react'

const {Title} = Typography

const UserForm = () => {
  const {userId} = useParams()
  const [{data: usersResponse, loading: usersLoading}, getUser] = useGet<UserResponse>('')

  useEffect(() => {
    if (userId !== 'add') {
      getUser({url: `/api/v1/users/${userId}`})
    }
  }, [userId])

  const isEdit = userId !== 'add'

  return (
      <Layout style={{padding: '50px 50px', height: '100vh'}}>
        <Title level={3}>{isEdit ? 'Редактирование сотрудника' : 'Создание сотрудника'}</Title>
        {usersLoading ? (
            <Spin size='large'/>
        ) : (
            <Form layout='vertical'>
              <Form.Item
                  label='Имя'
                  rules={[{required: true}]}
              >
                <Input/>
              </Form.Item>
              <Form.Item label='Фамилия'>
                <Input/>
              </Form.Item>
              <Form.Item
                  label='Email'
                  rules={[
                    {required: true},
                    {
                      type: 'email',
                      message: 'The input is not valid E-mail!'
                    }
                  ]}
              >
                <Input/>
              </Form.Item>
              <Form.Item label='Номер телефона'>
                <Input/>
              </Form.Item>
              <Form.Item
                  label='Роль'
                  rules={[{required: true}]}
              >
                <Input/>
              </Form.Item>
            </Form>
        )}
      </Layout>
  )
}

export default UserForm
