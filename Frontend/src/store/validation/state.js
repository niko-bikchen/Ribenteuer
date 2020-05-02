export default function() {
  return {
    validators: {
      notEmpty: [value => value !== '' || 'Field cannot be empty'],
      email: [value => /^\w+@\w+\.\w+$/.test(value) || 'Field must contain a valid email'],
      password: [value => value.length >= 10 || 'Password should be at least 10 symbols long'],
      userName: [
        value => value !== '' || 'Nickname cannot be empty',
        value => /^\w+$/.test(value) || 'Nickname can contain only letters, numbers and underscores'
      ],
      characterName: [
        value => value !== '' || 'Character name cannot be empty',
        value =>
          /^\w+$/.test(value) || 'Character name can contain only letters, numbers and underscores'
      ]
    }
  };
}
