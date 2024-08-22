import React from 'react';
import { useState } from 'react';

import { Label } from '../ui/label';

import { Input } from '../ui/input';

const PageComponent = () => {
  const [formData, setFormData] = useState({});

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {
    // Save form data
  };

  return (
    <div>
      <h1>lksdfsldjkl</h1>
      <div className='flex flex-col gap-2 w-full'>
        <Label style={{
          color: '',
          fontSize: 16,
        }}>
          Text field <span className='text-red-600 font-bold'>*</span>
        </Label>
        <Input
          placeholder='value here...'
          style={{
            color: '',
            fontSize: 16px,
            height: 50px,
            width: 500px,
          }}
          name='textfield'
          onChange={handleChange}
        />
      </div>
    </div>
  );
};

export default PageComponent;
