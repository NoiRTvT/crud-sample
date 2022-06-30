import {Button, Col, Input, Layout, Row, Space, Table, Typography} from 'antd'
import {useGet} from '../../utils'
import {User, UserResponse} from './types'
import {useState} from 'react'
import {useNavigate} from 'react-router-dom'

const {Title} = Typography
const {Search} = Input

const transformRoles: Record<string, string> = {
  OWNER: 'Владелец',
  EMPLOYEE: 'Сотрудник',
  DEVELOPER: 'Разработчик'
}

const UsersPage = () => {
  const [{data: usersResponse, loading: usersLoading}, getUsers] = useGet<UserResponse>('/api/v1/users')
  const [page, setPage] = useState(1)
  const [search, setSearch] = useState('')
  const navigate = useNavigate()

  const onChangePagination = (newPage: number) => {
    try {
      setPage(newPage)
      getUsers({params: {page: newPage - 1, search}})
    } catch (e) {
    }
  }
  const onSearch = (value: string) => {
    try {
      setPage(1)
      setSearch(value)
      getUsers({params: {search: value}})
    } catch (e) {
    }
  }

  const dataSource = (usersResponse?.users ?? []).map((it, index) => ({
    ...it,
    key: index,
    name: `${it.firstName} ${it.lastName}`
  }))
  const columns = [
    {
      title: 'Имя',
      dataIndex: 'name',
      key: 'name'
    },
    {
      title: 'Email',
      dataIndex: 'email',
      key: 'email'
    },
    {
      title: 'Номер телефона',
      dataIndex: 'phoneNumber',
      key: 'phoneNumber'
    },
    {
      title: 'Роль',
      dataIndex: 'role',
      key: 'role',
      render: (_: unknown, record: User) => transformRoles[record.role]
    }
  ]

  return (
      <Layout style={{padding: '50px 50px', height: '100vh'}}>
        <Title level={3}>Сотрудники</Title>
        <Space
            direction='vertical'
            size='middle'
        >
          <Row gutter={8}>
            <Col>
              <Search
                  value={search}
                  onChange={(e) => setSearch(e.target.value)}
                  onSearch={(value) => onSearch(value)}
                  allowClear
              />
            </Col>
            <Col>
              <Button
                  type='primary'
                  onClick={() => navigate('/users/add', {replace: true})}
              >
                Добавить
              </Button>
            </Col>
          </Row>
          <Table
              loading={usersLoading}
              dataSource={dataSource}
              columns={columns}
              pagination={{
                total: usersResponse?.pagination?.totalElements ?? 0,
                size: 'small',
                current: page,
                onChange: (page) => onChangePagination(page)
              }}
              size='small'
          />
        </Space>
      </Layout>
  )
}

export default UsersPage
